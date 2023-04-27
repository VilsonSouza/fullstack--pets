import type { NextPage } from 'next';
import Titulo from '../ui/components/Titulo/Titulo';
import Lista from '../ui/components/Lista/Lista';
import { Dialog, TextField,Grid,DialogActions,Button,Snackbar} from '@mui/material';
import { useState } from 'react';
import { useIndex } from '../ui/data/hooks/pages/useindex';



const Home: NextPage = () => {
 const {
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
 } =useIndex();

  return (
    <div>
      <Titulo 
      titulo="aaa"
      subtitulo={
        <span>
          Com um pequeno valor mensal,você <br />
          pode <strong>adotar um pet virtualmente</strong>
        </span>
      }/>

      <Lista
        pets={listaPets}
        onSelect={(pet)=> setpetSelecionado(pet)}
      />
      <Dialog open={petSelecionado !== null}
        fullWidth
        PaperProps={{sx:{p:5}}}
        onClose={() => setpetSelecionado(null)}
      >
        <Grid container spacing={2}>
          <Grid item xs={12}>
          <TextField
          label={'email'}
          type={'email'}
          fullWidth
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        </Grid>

        <Grid item xs={12}>
          <TextField
          label={'Quantia por mês'}
          type={'number'}
          fullWidth
          value={valor}
          onChange={(e) => setValor(e.target.value)}
        />
        </Grid>
        </Grid>
        <DialogActions sx={{mt: 5}} >
          <Button
          color={'secondary'}
          onClick={() => setpetSelecionado(null)}
          >
            Cancelar
         </Button>
         <Button
          variant={'contained'}
          onClick={() => adotar()}
         >
           Confirmar adoção
         </Button>

        </DialogActions>
      </Dialog>

      <Snackbar
        open={mensagem.length>0}
        message={mensagem}
        autoHideDuration={2500}
        onClose={() => setMensagem('')}
      />


    </div>
  )
}

export default Home
