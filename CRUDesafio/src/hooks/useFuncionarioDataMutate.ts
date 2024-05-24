import axios, { AxiosPromise } from "axios"
import { FuncionarioData } from "../interface/FuncionarioData";
import { useMutation, useQueryClient } from "@tanstack/react-query";

const API_URL = 'http://localhost:8090';

const postData = async (data: FuncionarioData): AxiosPromise<any> => {
    const response = axios.post(API_URL +  '/funcionario', data)
    return response;
}

export function useFuncionarioDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey:['funcionario-data']})
        }
    })

    return mutate;
}