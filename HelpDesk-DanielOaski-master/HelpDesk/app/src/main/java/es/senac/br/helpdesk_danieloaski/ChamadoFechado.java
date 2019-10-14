package es.senac.br.helpdesk_danieloaski;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import es.senac.br.helpdesk.R;
import es.senac.br.helpdesk_danieloaski.api.ChamadoTask;
import es.senac.br.helpdesk_danieloaski.api.OnEventListener;
import es.senac.br.helpdesk_danieloaski.model.FechadosChamados;

public class ChamadoFechado extends Fragment {
    ListView listaMsgChamadosFechados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.fragment_chamado_fechado, container, false);

        final List<FechadosChamados> chamadosListaFechados = new ArrayList<FechadosChamados>();


        ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {

            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "CHAMADOS FECHADOS ", Toast.LENGTH_LONG).show();

                Gson gson = new Gson();

                FechadosChamados[] chamadosFechados = gson.fromJson(result, FechadosChamados[].class);

                for (FechadosChamados chamado: chamadosFechados){
                    if(chamado.getStatus().toLowerCase().equals("chamadosfechado")){

                        chamadosListaFechados.add(chamado);

                    }

                    ArrayAdapter<FechadosChamados> adapter = new ArrayAdapter<FechadosChamados>(getActivity(),
                            android.R.layout.simple_list_item_1, chamadosListaFechados);

                    listaMsgChamadosFechados = (ListView) view.findViewById(R.id.listChamadoFechado);

                    listaMsgChamadosFechados.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        chamadoTask.execute();


        return view;
    }
}

