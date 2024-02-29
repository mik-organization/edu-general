// Stasic site Genration
export default function IndexPage(){
    return <h3>SG</h3>
}

export async function getStaticProps(){

    // console.log('getStaticProps');

    return{
        props: { message: 'From static Props' }
    }
} 