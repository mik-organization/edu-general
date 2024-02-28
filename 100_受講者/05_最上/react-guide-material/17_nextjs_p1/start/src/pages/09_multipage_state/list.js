import List from "../../components/list";
import { useAppContext } from "../../context/AppContext";
import { useRouter } from "next/router";
import Link from "next/Link"

export default function PageList() {
    const [list, ] = useAppContext();
    const router = useRouter();

    return (
        <>
        <List list={list} />
        <button onClick={() => router.back()}>前のページへ</button>
        <button onClick={() => router.push('/09_multipage_state/')}>戻る</button>
        <Link href='/09_multipage_state'>
        <a>
          戻る
        </a>
      </Link>
        </>
    )
}