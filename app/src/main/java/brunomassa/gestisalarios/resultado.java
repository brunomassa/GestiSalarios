package brunomassa.gestisalarios;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFlat;


public class resultado extends ActionBarActivity {

    Toolbar barra3,barrakk3;
    String nomefamilia,rendimento,result,gastos;
   TextView texto,texto_descrisao;
    ImageView img;
    ButtonFlat sugestoes;
    Intent sugest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //transition
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Fade trs=new Fade();
            trs.setDuration(1000);
            getWindow().setEnterTransition(trs);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //barra kitkat
        barrakk3=(Toolbar)findViewById(R.id.barkk3);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.KITKAT||Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            barrakk3.setVisibility(View.GONE);
        }

        //barra
        barra3=(Toolbar)findViewById(R.id.bar3);
        barra3.setTitle("GestiSalarios");
        barra3.setTitleTextColor(getResources().getColor(android.R.color.white));
        barra3.setSubtitle("Resultado");
        setSupportActionBar(barra3);

        //strings
        nomefamilia=getIntent().getStringExtra("strnomefamilia");
        rendimento=getIntent().getStringExtra("strrendimento");
        gastos=getIntent().getStringExtra("strgastos");
        result=getIntent().getStringExtra("strresult");

        //texto
        texto=(TextView)findViewById(R.id.textView8);
        texto.setText(result);

        texto_descrisao=(TextView)findViewById(R.id.textView9);


        //Imageview
        img=(ImageView)findViewById(R.id.imageView);

        if(texto.getText().toString().equals("Bom")){
            img.setImageResource(R.mipmap.ic_mood_black_48dp);
            texto_descrisao.setText("Os teus gastos estao dentro da estabilidade nao precisas de dar grande atenção.\nNo entanto se quiseres podes reduzir os gastos.");
        }
        if(texto.getText().toString().equals("medio")){
            img.setImageResource(R.mipmap.neutral);
            texto_descrisao.setText("Os teus gastos estao no limite da estabilidade.\nTenta manter ou reduzir os gastos.");
        }
        if(texto.getText().toString().equals("mau")){
            img.setImageResource(R.mipmap.sad);
            texto_descrisao.setText("Os teus gastos são muito elevados para o rendimento que dispões.\nTenta reduzir os gastos.");

        }

        sugestoes=(ButtonFlat)findViewById(R.id.buttonflat2);
        sugestoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat ops = ActivityOptionsCompat.makeSceneTransitionAnimation(resultado.this, null);

                    sugest = new Intent(resultado.this, soguestoes.class);
                    startActivity(sugest,ops.toBundle());
                }
                else {
                    sugest = new Intent(resultado.this, soguestoes.class);
                    startActivity(sugest);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
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
