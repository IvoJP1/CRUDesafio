import { useEffect, useState } from "react"
import { useFuncionarioDataPut } from "../../hooks/useFuncionarioDataPut";
import { FuncionarioData } from "../../interface/FuncionarioData";
import { useUmFuncionarioData } from "../../hooks/useUmFuncionarioData";

import "./modal.css"
import axios from "axios";

interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: any): void
}

interface ModalProps {
    closeModal(): void,
    funcionarioId: number
} 



const Input = ({label, value, updateValue}: InputProps) => {
    return(
        <>
            <label>{label}</label>
            <input value = {value} onChange = {e => updateValue(e.target.value)}></input>
        </>
    )
}




export function UpdateModal({closeModal, funcionarioId}: ModalProps){
    const [nome, setNome] = useState("");
    const [cpf, setCpf] = useState("");
    const [img, setImg] = useState("");
    const [email, setEmail] = useState("");
    const [endereco, setendereco] = useState("");
    const [telefone, setTelefone] = useState("");
    const {mutate, isSuccess} = useFuncionarioDataPut(); 

    //const funcionario = useUmFuncionarioData(funcionarioId) 

    const API_URL = 'http://localhost:8090';

    const fetchData = async (id: number) => {
        const response = await axios.get(API_URL +  `/funcionario/one?id=${id}`)
        const funcionario = response.data
        setNome(funcionario.nome)
        setCpf(funcionario.cpf)
        setImg(funcionario.img)
        setEmail(funcionario.email)
    }
    

    const putData = async (data: FuncionarioData)  => {
        const response = axios.put(API_URL +  '/funcionario', data)
        return response;
    }

    const submit = () => {
        const funcionarioData: FuncionarioData = {
            id: funcionarioId,
            nome,
            cpf,
            img,
            email,
            endereco,
            telefone
        }

        putData(funcionarioData)
        closeModal();
        //mutate(funcionarioData)
    }

    useEffect(() => {
        if(!isSuccess) return
        closeModal();
        fetchData(funcionarioId);
    }, [isSuccess])

    useEffect(() => {
        fetchData(funcionarioId);
    }, [])

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