import axios, { AxiosPromise } from "axios"
import { FuncionarioData } from "../interface/FuncionarioData";
import { useMutation, useQueryClient } from "@tanstack/react-query";

const API_URL = 'http://localhost:8090';

const putData = async (data: FuncionarioData): AxiosPromise<any> => {
    const response = axios.put(API_URL +  '/funcionario', data)
    return response;
}

export function useFuncionarioDataPut(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: putData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey:['funcionario-data']})
        }
    })

    return mutate;
}