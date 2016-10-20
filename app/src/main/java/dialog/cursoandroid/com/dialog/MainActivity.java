package dialog.cursoandroid.com.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botaoId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //criar alert dialog
                dialog = new AlertDialog.Builder(getApplicationContext());

                //configurar o título
                dialog.setTitle("Título da dialog");

                //configurar a msg
                dialog.setMessage("Mensagem da dialog");

                //botão negativo
                dialog.setNegativeButton("não",
                        new DialogInterface.OnClickListener() { //passado a msg 'não' e uma chamada de evento no clique do 'não'.
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"Pressionado botão não", Toast.LENGTH_SHORT).show();;
                            }
                        });
                //botão positivo
                dialog.setPositiveButton("sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Pressionado botão sim", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.setCancelable(false);    //Quando pressionado fora da caixa de diálogo, não fecha a janela de 'dialogo'.
                dialog.setIcon(android.R.drawable.ic_delete);   //ícone mostrado no título.

                dialog.create();
                dialog.show();

            }
        });
    }
}
