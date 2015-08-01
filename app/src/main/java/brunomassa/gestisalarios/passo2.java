package brunomassa.gestisalarios;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;


public class passo2 extends ActionBarActivity {

    Toolbar barra1,barrakk1;
    EditText elementos,rendimento;
    ImageButton botao1;
    String nomefamilia;
    TextView texto,txtrendimento;
    Intent pas3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //transiction

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Explode trs=new Explode();
            trs.setDuration(500);
            getWindow().setEnterTransition(trs);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passo2);

        //barra kitkat
        barrakk1=(Toolbar)findViewById(R.id.barkk1);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.KITKAT||Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            barrakk1.setVisibility(View.GONE);
        }

        //barra
        barra1=(Toolbar)findViewById(R.id.bar1);
        barra1.setTitle("GestiSalarios");
        barra1.setTitleTextColor(getResources().getColor(android.R.color.white));
        barra1.setSubtitle("Passo 2 de 3: número de elementos");
        setSupportActionBar(barra1);


        //edittext
        elementos=(EditText)findViewById(R.id.editText2);
        rendimento=(EditText)findViewById(R.id.editText7);


        //FAB
        botao1=(ImageButton)findViewById(R.id.fab2);
        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.KITKAT){
            ViewGroup.MarginLayoutParams mlp=(ViewGroup.MarginLayoutParams)botao1.getLayoutParams();
            mlp.bottomMargin=130;
            botao1.setLayoutParams(mlp);

        }
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(elementos.length()==0||rendimento.length()==0){
                    SnackbarManager.show(Snackbar.with(passo2.this)
                            .type(SnackbarType.MULTI_LINE)
                            .text("Deve preencher todos os campos.")
                            .color(passo2.this.getResources().getColor(android.R.color.black))
                            .textColor(passo2.this.getResources().getColor(android.R.color.white))
                            .duration(Snackbar.SnackbarDuration.LENGTH_LONG));
                }else {

                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        ActivityOptionsCompat ops= ActivityOptionsCompat.makeSceneTransitionAnimation(passo2.this,null);

                        pas3 = new Intent(passo2.this, passo3.class);
                        pas3.putExtra("strnomefamilia", nomefamilia);
                        pas3.putExtra("strrendimento", rendimento.getText().toString());
                        startActivity(pas3,ops.toBundle());
                        passo2.this.finish();
                    }
                    else {
                        pas3 = new Intent(passo2.this, passo3.class);
                        pas3.putExtra("strnomefamilia", nomefamilia);
                        pas3.putExtra("strrendimento", rendimento.getText().toString());
                        startActivity(pas3);
                        passo2.this.finish();
                    }
                }
            }
        });

        nomefamilia=getIntent().getStringExtra("strnome");

        //textview
        texto=(TextView)findViewById(R.id.textView2);
        texto.setText(texto.getText().toString()+" da familia "+nomefamilia+":");
        txtrendimento=(TextView)findViewById(R.id.textView7);
        txtrendimento.setText(txtrendimento.getText().toString()+" da familia "+nomefamilia+":");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_passo2, menu);
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
