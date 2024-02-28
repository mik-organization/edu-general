import { useEffect, useState } from "react";

export function SSR({ message }){
    console.log('hello');
    console.log(message);
   
    useEffect(() => {
        console.log('useEffect');
        window.localStorage.setItem('key', 'value');
        document.cookie = 'val=0; path=/;'  
    },[])
    const [ state, setState ] = useState('bye');
    const val = 0
    return <h3>{state}</h3>
}

export async function getServerSideProps(){

    const { cookie } = context.req.heders;
    console.log('cookie', cookie);
    console.log('getServerSideProps is executed');
    return {
        // rediect: {
        //     destination: '/',
        //     permanent:false
        // },
        props: {message: 'From Server Slid'}
    }
}