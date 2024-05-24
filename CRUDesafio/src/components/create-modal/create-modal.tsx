import { useEffect, useState } from "react"
import { useFuncionarioDataMutate } from "../../hooks/useFuncionarioDataMutate";
import { FuncionarioData } from "../../interface/FuncionarioData";

import "./modal.css"

interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: any): void
}

interface ModalProps {
    closeModal(): void
} 



const Input = ({label, value, updateValue}: InputProps) => {
    return(
        <>
            <label>{label}</label>
            <input value = {value} onChange = {e => updateValue(e.target.value)}></input>
        </>
    )
}



export function CreateModal({closeModal}: ModalProps){
    const [nome, setNome] = useState("");
    const [cpf, setCpf] = useState("");
    const [img, setImg] = useState("");
    const [email, setEmail] = useState("");
    const [endereco, setendereco] = useState("");
    const [telefone, setTelefone] = useState("");
    const {mutate, isSuccess} = useFuncionarioDataMutate(); 

    const submit = () => {
        const funcionarioData: FuncionarioData = {
            nome,
            cpf,
            img,
            email,
            endereco,
            telefone
        }

        mutate(funcionarioData)
    }

    useEffect(() => {
        if(!isSuccess) return
        closeModal();
    }, [isSuccess])

    return(
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>
                    Cadastre um novo funcionário:
                </h2>
                <form className="input-container">
                    <Input label="nome" value={nome} updateValue={setNome}/>
                    <Input label="cpf" value={cpf} updateValue={setCpf}/>
                    <Input label="img" value={img} updateValue={setImg}/>
                    <Input label="email" value={email} updateValue={setEmail}/>
                
                </form>
                <button onClick={submit} className="btn-secondary">Postar</button>
            </div>
        </div>
    )
}