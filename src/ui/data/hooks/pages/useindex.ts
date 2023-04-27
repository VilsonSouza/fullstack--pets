import { useState, useEffect } from "react"
import { Pet } from "../../@types/Pet";
import { ApiService } from "../../../../pages/services/ApiService";
import { AxiosError } from "axios";
export function useIndex(){
   const [listaPets, setlistaPets] = useState<Pet[]>([]),
        [petSelecionado,setpetSelecionado]=useState<Pet | null>(null),
        [email,setEmail] =useState(''),
        [valor,setValor] = useState(''),
        [mensagem,setMensagem]= useState('');

    useEffect( ()=> {
         ApiService.get("/pets")
            .then((resposta) =>{
                setlistaPets (resposta.data);
            })

        }, [])
    useEffect( () =>{
        if(petSelecionado ===null){
            limparFormulario();
        }
    },[petSelecionado])

        function adotar(){
            if(petSelecionado !== null){
                if(validarDadosAdocao()){
                    ApiService.post("/adocoes",{
                        pet_id: petSelecionado.id,
                        email,
                        valor

                    })
                    .then(()=> {
                        setpetSelecionado(null),
                        setMensagem('Pet Adotado com Sucesso');
                       
                    })
                    .catch((error: AxiosError)=> {
                        setMensagem(error.response?.data.message);
                    })
                }
                else{
                    setMensagem('Preencha todos os campos corretamente')
                }
            }
        }

        function validarDadosAdocao(){
            return email.length >0 && valor.length>0;
        }
        function limparFormulario(){
            setEmail('');
            setValor('');
        }
    return{
        listaPets,
        petSelecionado,
        setpetSelecionado,
        email,
        setEmail,
        valor,
        setValor,
        mensagem,
        setMensagem,
        adotar

    };

}