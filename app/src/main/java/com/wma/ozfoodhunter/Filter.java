package com.wma.ozfoodhunter;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Filter extends AppCompatActivity {


    Toolbar toolbar;
    ActionBar actionbar;
    TextView all,indian,asian,japanese,nepalese,burger,pizza,italian,vietnamese,thai,mexican,chinese,pakistani,pasta,kebab,venues,first,loyalty,min,meal;
    int a=0;
    int b=0;
    int c=0;
    int d=0;
    int e=0;
    int f=0;
    int g=0;
    int h=0;
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    int m=0;
    int n=0;
    int o=0;
    int p=0;
    int q=0;
    int r=0;
    int s=0;
    int t=0;
    int u=0;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.filter_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);

        all=(TextView) findViewById(R.id.all);
        indian=(TextView) findViewById(R.id.indian);
        asian=(TextView) findViewById(R.id.asian);
        japanese=(TextView) findViewById(R.id.japanese);
        nepalese=(TextView) findViewById(R.id.nepalese);
        burger=(TextView) findViewById(R.id.burger);
        pizza=(TextView) findViewById(R.id.pizza);
        italian=(TextView) findViewById(R.id.italian);
        vietnamese=(TextView) findViewById(R.id.vietnamese);
        thai=(TextView) findViewById(R.id.thai);
        mexican=(TextView) findViewById(R.id.mexican);
        chinese=(TextView) findViewById(R.id.chinese);
        pakistani=(TextView) findViewById(R.id.pakistani);
        pasta=(TextView) findViewById(R.id.pasta);
        kebab=(TextView) findViewById(R.id.kebab);
        venues=(TextView) findViewById(R.id.venues);
        first=(TextView) findViewById(R.id.first);
        loyalty=(TextView) findViewById(R.id.loyalty);
        min=(TextView) findViewById(R.id.min);
        meal=(TextView) findViewById(R.id.meal);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                if(a%2 == 1){
                    all.setBackgroundResource(R.drawable.rectangle_edge_green);
                    all.setTextColor(getResources().getColor(R.color.white));
                }else{
                    all.setBackgroundResource(R.drawable.rectangle_edge_white);
                    all.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });

        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b++;
                if(b%2 == 1){
                    indian.setBackgroundResource(R.drawable.rectangle_edge_green);
                    indian.setTextColor(getResources().getColor(R.color.white));
                }else{
                    indian.setBackgroundResource(R.drawable.rectangle_edge_white);
                    indian.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                if(c%2 == 1){
                    asian.setBackgroundResource(R.drawable.rectangle_edge_green);
                    asian.setTextColor(getResources().getColor(R.color.white));
                }else{
                    asian.setBackgroundResource(R.drawable.rectangle_edge_white);
                    asian.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d++;
                if(d%2 == 1){
                    japanese.setBackgroundResource(R.drawable.rectangle_edge_green);
                    japanese.setTextColor(getResources().getColor(R.color.white));
                }else{
                    japanese.setBackgroundResource(R.drawable.rectangle_edge_white);
                    japanese.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        nepalese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e++;
                if(e%2 == 1){
                    nepalese.setBackgroundResource(R.drawable.rectangle_edge_green);
                    nepalese.setTextColor(getResources().getColor(R.color.white));
                }else{
                    nepalese.setBackgroundResource(R.drawable.rectangle_edge_white);
                    nepalese.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f++;
                if(f%2 == 1){
                    burger.setBackgroundResource(R.drawable.rectangle_edge_green);
                    burger.setTextColor(getResources().getColor(R.color.white));
                }else{
                    burger.setBackgroundResource(R.drawable.rectangle_edge_white);
                    burger.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g++;
                if(g%2 == 1){
                    pizza.setBackgroundResource(R.drawable.rectangle_edge_green);
                    pizza.setTextColor(getResources().getColor(R.color.white));
                }else{
                    pizza.setBackgroundResource(R.drawable.rectangle_edge_white);
                    pizza.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h++;
                if(h%2 == 1){
                    italian.setBackgroundResource(R.drawable.rectangle_edge_green);
                    italian.setTextColor(getResources().getColor(R.color.white));
                }else{
                    italian.setBackgroundResource(R.drawable.rectangle_edge_white);
                    italian.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        vietnamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i%2 == 1){
                    vietnamese.setBackgroundResource(R.drawable.rectangle_edge_green);
                    vietnamese.setTextColor(getResources().getColor(R.color.white));
                }else{
                    vietnamese.setBackgroundResource(R.drawable.rectangle_edge_white);
                    vietnamese.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        thai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                j++;
                if(j%2 == 1){
                    thai.setBackgroundResource(R.drawable.rectangle_edge_green);
                    thai.setTextColor(getResources().getColor(R.color.white));
                }else{
                    thai.setBackgroundResource(R.drawable.rectangle_edge_white);
                    thai.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        mexican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k++;
                if(k%2 == 1){
                    mexican.setBackgroundResource(R.drawable.rectangle_edge_green);
                    mexican.setTextColor(getResources().getColor(R.color.white));
                }else{
                    mexican.setBackgroundResource(R.drawable.rectangle_edge_white);
                    mexican.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m++;
                if(m%2 == 1){
                    chinese.setBackgroundResource(R.drawable.rectangle_edge_green);
                    chinese.setTextColor(getResources().getColor(R.color.white));
                }else{
                    chinese.setBackgroundResource(R.drawable.rectangle_edge_white);
                    chinese.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        pakistani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n++;
                if(n%2 == 1){
                    pakistani.setBackgroundResource(R.drawable.rectangle_edge_green);
                    pakistani.setTextColor(getResources().getColor(R.color.white));
                }else{
                    pakistani.setBackgroundResource(R.drawable.rectangle_edge_white);
                    pakistani.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o++;
                if(o%2 == 1){
                    pasta.setBackgroundResource(R.drawable.rectangle_edge_green);
                    pasta.setTextColor(getResources().getColor(R.color.white));
                }else{
                    pasta.setBackgroundResource(R.drawable.rectangle_edge_white);
                    pasta.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        kebab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p++;
                if(p%2 == 1){
                    kebab.setBackgroundResource(R.drawable.rectangle_edge_green);
                    kebab.setTextColor(getResources().getColor(R.color.white));
                }else{
                    kebab.setBackgroundResource(R.drawable.rectangle_edge_white);
                    kebab.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        venues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q++;
                if(q%2 == 1){
                    venues.setBackgroundResource(R.drawable.rectangle_edge_green);
                    venues.setTextColor(getResources().getColor(R.color.white));
                }else{
                    venues.setBackgroundResource(R.drawable.rectangle_edge_white);
                    venues.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r++;
                if(r%2 == 1){
                    first.setBackgroundResource(R.drawable.rectangle_edge_green);
                    first.setTextColor(getResources().getColor(R.color.white));
                }else{
                    first.setBackgroundResource(R.drawable.rectangle_edge_white);
                    first.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        loyalty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s++;
                if(s%2 == 1){
                    loyalty.setBackgroundResource(R.drawable.rectangle_edge_green);
                    loyalty.setTextColor(getResources().getColor(R.color.white));
                }else{
                    loyalty.setBackgroundResource(R.drawable.rectangle_edge_white);
                    loyalty.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t++;
                if(t%2 == 1){
                    min.setBackgroundResource(R.drawable.rectangle_edge_green);
                    min.setTextColor(getResources().getColor(R.color.white));
                }else{
                    min.setBackgroundResource(R.drawable.rectangle_edge_white);
                    min.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });
        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u++;
                if(u%2 == 1){
                    meal.setBackgroundResource(R.drawable.rectangle_edge_green);
                    meal.setTextColor(getResources().getColor(R.color.white));
                }else{
                    meal.setBackgroundResource(R.drawable.rectangle_edge_white);
                    meal.setTextColor(getResources().getColor(R.color.green));
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
