import { Button } from '@mui/material'
import {
    ListaStyled,
    ItemLista,
    Foto,
    Informacoes,
    Nome,
    Descricao

}from './Lista.style'

import { Pet } from '../../../ui/data/@types/Pet'

interface ListaProps{
    pets:Pet[];
    onSelect: (pet:Pet) =>void;
}

export default function Lista(props:ListaProps){
    return(
      <ListaStyled>
          {props.pets.map(pet =>(
            <ItemLista key={pet.id}>
                <Foto src={pet.foto} alt={pet.nome}/>
                <Informacoes>
                    <Nome>{pet.nome}</Nome>
                    <Descricao>
                        {pet.historia}
                    </Descricao>
                    <Button
                        variant={"contained"}
                        fullWidth
                        onClick={() => props.onSelect(pet)}
                    >Adotar</Button>
                </Informacoes>
            </ItemLista>
          ))}   
      </ListaStyled>
    )
}