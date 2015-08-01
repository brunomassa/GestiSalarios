package brunomassa.gestisalarios;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.gc.materialdesign.views.ButtonFlat;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;


public class passo3 extends ActionBarActivity {

    Toolbar barra2,barrakk2;
    String nomefamilia,rendimento,result;
    Intent resultado;
    EditText agua,luz,alimentacao,outras;
    Double ag;
    Double lz;
    Double almt;
    Double otr;
    Double rdmt;
    Double prc;
    Double totalgastos;
    ButtonFlat verificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //transiction

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Explode trs=new Explode();
            trs.setDuration(500);
            getWindow().setEnterTransition(trs);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passo3);

        //barra kitkat
        barrakk2=(Toolbar)findViewById(R.id.barkk2);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.KITKAT||Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            barrakk2.setVisibility(View.GONE);
        }

        //barra
        barra2=(Toolbar)findViewById(R.id.bar2);
        barra2.setTitle("GestiSalarios");
        barra2.setTitleTextColor(getResources().getColor(android.R.color.white));
        barra2.setSubtitle("Passo 3 de 3: Despesas");
        setSupportActionBar(barra2);

        //string
        nomefamilia=getIntent().getStringExtra("strnomefamilia");
        rendimento=getIntent().getStringExtra("strrendimento");

        //Edittext
        agua=(EditText)findViewById(R.id.editText3);
        luz=(EditText)findViewById(R.id.editText4);
        alimentacao=(EditText)findViewById(R.id.editText5);
        outras=(EditText)findViewById(R.id.editText6);

        verificar=(ButtonFlat)findViewById(R.id.buttonflat);
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // butao

                try {
                    if(agua.length()==0|| luz.length()==0||alimentacao.length()==0||outras.length()==0){
                        SnackbarManager.show(Snackbar.with(passo3.this)
                                .type(SnackbarType.MULTI_LINE)
                                .text("Deve preencher todos os campos.")
                                .color(passo3.this.getResources().getColor(android.R.color.black))
                                .textColor(passo3.this.getResources().getColor(android.R.color.white))
                                .duration(Snackbar.SnackbarDuration.LENGTH_LONG));

                    }else {

                        rdmt = Double.valueOf(rendimento);

                        ag = Double.valueOf(agua.getText().toString());
                        lz = Double.valueOf(luz.getText().toString());
                        almt = Double.valueOf(alimentacao.getText().toString());
                        otr = Double.valueOf(outras.getText().toString());

                        prc = rdmt / 2;


                        totalgastos = ag + lz + almt + otr;


                        if (totalgastos > prc) {
                            result = "mau";

                        }
                        if (totalgastos == prc) {
                            result = "medio";

                        }
                        if (prc > totalgastos) {
                            result = "Bom";

                        }

                        new AlertDialogWrapper.Builder(passo3.this)
                                .setTitle("verificação")
                                .setMessage("Pretende proseguir com a verificação?")
                                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                            ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(passo3.this, null);

                                            resultado = new Intent(passo3.this, brunomassa.gestisalarios.resultado.class);
                                            resultado.putExtra("strnomefamilia", nomefamilia);
                                            resultado.putExtra("strrendimento", rendimento);
                                            resultado.putExtra("strgastos", String.valueOf(totalgastos));
                                            resultado.putExtra("strresult", result);
                                            startActivity(resultado,ops.toBundle());
                                            passo3.this.finish();
                                        } else {
                                            resultado = new Intent(passo3.this, brunomassa.gestisalarios.resultado.class);
                                            resultado.putExtra("strnomefamilia", nomefamilia);
                                            resultado.putExtra("strrendimento", rendimento);
                                            resultado.putExtra("strgastos", String.valueOf(totalgastos));
                                            resultado.putExtra("strresult", result);
                                            startActivity(resultado);
                                            passo3.this.finish();
                                        }
                                    }
                                }).show();

                    }

                }catch (Exception ex){
                    Toast.makeText(passo3.this, ex.toString(), Toast.LENGTH_LONG).show();
                }
            }


        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_passo3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
