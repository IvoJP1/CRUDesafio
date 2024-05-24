import axios, * as axios_1 from "axios"
import { FuncionarioData } from "../interface/FuncionarioData";
import { useQuery } from "@tanstack/react-query";

const API_URL = 'http://localhost:8090';

const fetchData = async (id: number): axios_1.AxiosPromise<FuncionarioData> => {
    const response = axios.get(API_URL +  `/funcionario/one?id=${id}`)
    return response;
}

export function useUmFuncionarioData(id: number){
    const query = useQuery({
        queryFn: () =>  fetchData(id),
        queryKey: ['funcionario-data'],
        retry: 2
    })

    return {
        ...query,
        data: query.data?.data
    }
}