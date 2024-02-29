import axios from "axios";

const JSON_SEVER_URL = `${process.env.JSON_SEVER_URL}/articles`;

export default async function handler(req, res) {

    try {
        if (req.method === "GET") {
            const result = await axios.get(JSON_SEVER_URL).then(res => res.data);
            return res.status(200).json(result);
        }
    }catch{}

    return res.status(500).json({
        error: {
            status: 500,
            code: "BAD_REQUEST",
            message: "不正なリクエストです。"
        }
    })


}