import { useEffect, useState } from "react"
import { useFuncionarioDataPut } from "../../hooks/useFuncionarioDataPut";
import { FuncionarioData } from "../../interface/FuncionarioData";

import "./modal.css"
import axios from "axios";


interface ModalProps {
    closeModal(): void,
    funcionarioId: number
}

const API_URL = 'http://localhost:8090';

const deleteData = async (id: number) => {
    const response = axios.delete(API_URL + `/funcionario?id=${id}`)

}


export function DeleteModel({ closeModal, funcionarioId }: ModalProps) {

    return (
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Deseja excluir o cadastro?</h2>
                <button className="btn-secondary" onClick={() => {deleteData(funcionarioId) 
                    closeModal()} }>Sim</button> <button className="btn-secondary" onClick={closeModal}>Não</button>
            </div>
        </div>

    )

}