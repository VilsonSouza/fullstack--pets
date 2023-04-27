import { Link } from '@mui/material';
import NextLink from 'next/link'
import {
    CabeçalhoContainer,
    Logo,
    LinksContainer
} from './CabeçalhoAdmin.style';

export default function CabeçalhoAdmin(){
    return (
        <CabeçalhoContainer>
            <div>

                <Logo src={'/imagens/logo.svg'} alt={'Adote Um pet'}/>
                <LinksContainer>
                    <Link>Cadastrar Pet</Link>
                    <Link>Relatório de adoção</Link>
                </LinksContainer>
            </div>
            <NextLink href="/asd">
                <a>
                    asadsada
                </a>
            </NextLink>

        </CabeçalhoContainer>


    )
} 