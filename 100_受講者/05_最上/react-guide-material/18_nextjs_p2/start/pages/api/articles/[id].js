import axios from "axios";

const JSON_SEVER_URL = `${process.env.JSON_SEVER_URL}/articles`;

// リクエストURL
// http://localhost:3010/040_api_routes/1

export default async function handler(req, res) {

    const { method, query } =req;
    console.log(JSON_SEVER_URL);

    try {
        if (method === "GET") {
            const result = await axios.get(`${JSON_SEVER_URL}/${query}`).then(res => res.data);
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