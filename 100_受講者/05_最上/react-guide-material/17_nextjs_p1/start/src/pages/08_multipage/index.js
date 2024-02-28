import { useRouter } from "next/router";

export default function MultiPage() {
    const router = useRouter();
    const step = router.query.step ?? 0;    //[null合体演算子] nullまたはundifinedだった時、右側の値を返す

    const goToStep = (_step, asPath) => {
        router.push(`08_multipage?step=${_step}`, asPath)
    }
    // http://localhost:3000/08_multpage
    // http://localhost:3000/personal
    // http://localhost:3000/confirm
    // http://localhost:3000/08_multpage

    
    return (
        <div>
            {step == 0 && (
                <>
                    <h3>Step {step}</h3>
                    <button onClick={() => goToStep(1,"/personal")}>Next Step</button>
                </>
            )}
             {step == 1 && (
                <>
                    <h3>Step {step}</h3>
                    <button onClick={() => goToStep(2,"/confirm")}>Next Step</button>
                </>
            )}
            {step == 2 && (
                <>
                    <h3>Step {step}</h3>
                    <button onClick={() => goToStep(0,"/08_multpage")}>Next Step</button>
                </>
            )}
        </div>
    )
}