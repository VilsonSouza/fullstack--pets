import { TituloStyled,Subtitulo } from "./titulo.syle";

interface TituloProps{
    titulo:string;
    subtitulo:string | JSX.Element;
}

export default function Titulo(props:TituloProps){
    return (
    <>
        <TituloStyled>{props.titulo}</TituloStyled>
        <Subtitulo>{props.subtitulo}</Subtitulo> 
    </>
    )
}