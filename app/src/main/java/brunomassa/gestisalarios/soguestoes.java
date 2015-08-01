package brunomassa.gestisalarios;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class soguestoes extends ActionBarActivity {

    Toolbar barra4,barrakk4;
    TextView tv_sugestoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //transition
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Fade trs=new Fade();
            trs.setDuration(1000);
            getWindow().setEnterTransition(trs);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soguestoes);

        //barra kitkat
        barrakk4=(Toolbar)findViewById(R.id.barkk4);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.KITKAT||Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            barrakk4.setVisibility(View.GONE);
        }

        //barra
        barra4=(Toolbar)findViewById(R.id.bar4);
        barra4.setTitle("GestiSalarios");
        barra4.setTitleTextColor(getResources().getColor(android.R.color.white));
        barra4.setSubtitle("Algumas suguestoes");
        barra4.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        setSupportActionBar(barra4);

        barra4.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_sugestoes=(TextView)findViewById(R.id.textView11);
        tv_sugestoes.setText("- Realizar uma lista de compras.\n\n- Comprar só o essencial.\n\n- Realizar compras depois de almoçar ou jantar.\n\n" +
                "- Comprar os produtos com preços mais em conta.\n\n - Aproveitar sempre os descontos.\n\n - Comprar poucos produtos mas realizar as compras em varios dias da semana.\n");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_soguestoes, menu);
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
