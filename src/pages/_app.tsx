import '../ui/styles/globals.css'
import type { AppProps } from 'next/app'
import {ThemeProvider} from '@mui/material'
import tema from '../ui/temas/tema';
import Cabecalho from '../ui/components/cabecalho/cabecalho'
import CabeçalhoAdmin from '../ui/components/CabeçalhoAdmin/CabeçalhoAdmin';

function MyApp({ Component, pageProps }: AppProps) {
  return (
  <ThemeProvider theme={tema}>
    <CabeçalhoAdmin />
    <Component {...pageProps} />
  </ThemeProvider>
  )
}

export default MyApp
