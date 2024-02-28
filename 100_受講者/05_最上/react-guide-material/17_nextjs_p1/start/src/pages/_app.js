import '../styles/globals.css'
import { AppProvider  } from '../context/AppContext'
import Layout from "../components/layout/layout1";

function MyApp({ Component, pageProps }) {
  const getLayout = Component.getLayout ?? ((page) => <Layout>{page}</Layout>)
  return (
    <AppProvider>
      {getLayout(<Component {...pageProps} />)}
    </AppProvider>
  )
}

export default MyApp
