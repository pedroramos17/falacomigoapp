package br.com.etecia.falecomigo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView idLista;

    int imgProfile[] = {
            R.drawable.example_avatar,
            R.drawable.cara_sorriso,
            R.drawable.cara_oriental,
            R.drawable.baby,
    };

    String titulo[] = {
            "Uma Pessoa",
            "Sorriso em pessoa",
            "Alguém na foto",
            "Um baby",
    };

    String descricao[] = {
            "Uma descrição legal",
            "Cool description",
            "Além do horizonte",
            "Existe um lugar",
    };

    String rtBarCount[] = {
            "4.5",
            "4",
            "3.5",
            "2.5",
    };

    double rtBarStar[] = {
            0.9,
            0.8,
            0.7,
            0.5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        idLista = findViewById(R.id.idLista);

        MyAdapter adapter = new MyAdapter();

        //preparar para instanciar o adaptador
        idLista.setAdapter(adapter);
    }
    public class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return imgProfile.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //Variaveis de modelo
            ImageView imgPerfil, icFav, icShare;
            TextView nomePessoa, descricaoPessoa, idRtbarCount;
            RatingBar rtBar;

            //Adaptador ligando ao modelo
            View v = getLayoutInflater().inflate(R.layout.modelo_card,null);

            //Apresentar as variaveis do java para o modelo xml
            imgPerfil = v.findViewById(R.id.imgPerfil);
            icFav = v.findViewById(R.id.icFav);
            icShare = v.findViewById(R.id.icShare);
            nomePessoa = v.findViewById(R.id.nomePessoa);
            descricaoPessoa = v.findViewById(R.id.descricaoPessoa);
            idRtbarCount = v.findViewById(R.id.idRtbarCount);
            rtBar = v.findViewById(R.id.rtBar);

            //Inserindo valores nas variáveis Java
            imgPerfil.setImageResource(imgProfile[i]);
            nomePessoa.setText(titulo[i]);
            descricaoPessoa.setText(descricao[i]);
            idRtbarCount.setText(rtBarCount[i]);
            rtBar.setRating((float) rtBarStar[i]);
            icFav.setImageResource(R.drawable.ic_baseline_favorite_border_24);
            icShare.setImageResource(R.drawable.ic_baseline_share);

            return v;

        }
    }
}