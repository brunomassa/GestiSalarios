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
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;


public class MainActivity extends ActionBarActivity {

    Toolbar barra,barrakk;
    EditText nome;
    ImageButton botao;
    Intent pas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //barra kitkat
        barrakk=(Toolbar)findViewById(R.id.barkk);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.KITKAT||Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            barrakk.setVisibility(View.GONE);
        }


        //barra
        barra=(Toolbar)findViewById(R.id.bar);
        barra.setTitle("GestiSalarios");
        barra.setTitleTextColor(getResources().getColor(android.R.color.white));
        barra.setSubtitle("Passo 1 de 3: nome da familia");
        setSupportActionBar(barra);


        //edittext
        nome=(EditText)findViewById(R.id.editText);


        //FAB
        botao=(ImageButton)findViewById(R.id.fab1);
        if(Build.VERSION.SDK_INT==Build.VERSION_CODES.KITKAT){
            ViewGroup.MarginLayoutParams mlp=(ViewGroup.MarginLayoutParams)botao.getLayoutParams();
            mlp.bottomMargin=130;
            botao.setLayoutParams(mlp);

        }
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(nome.length()==0){
                        SnackbarManager.show(Snackbar.with(MainActivity.this)
                                .type(SnackbarType.MULTI_LINE)
                                .text("Deve preencher todos os campos.")
                                .color(MainActivity.this.getResources().getColor(android.R.color.black))
                                .textColor(MainActivity.this.getResources().getColor(android.R.color.white))
                                .duration(Snackbar.SnackbarDuration.LENGTH_LONG));
                    }
                    else {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                            ActivityOptionsCompat ops= ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,null);

                            pas2 = new Intent(MainActivity.this, passo2.class);
                            pas2.putExtra("strnome", nome.getText().toString());
                            startActivity(pas2, ops.toBundle());
                            MainActivity.this.finish();
                        }
                        else {
                            pas2 = new Intent(MainActivity.this, passo2.class);
                            pas2.putExtra("strnome", nome.getText().toString());
                            startActivity(pas2);
                            MainActivity.this.finish();
                        }
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this,""+ex.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
