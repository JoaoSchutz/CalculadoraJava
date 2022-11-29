package ads.schutz.univali.com.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*DECLARA OS ATRIBUTOS DOS BUTTONS, TEXTVIEWS, E IMAGEVIEWS CRIADOS NA ACTIVITY, PARA SEREM TRABALHADOS NOS MÉTODOS.*/
    private Button numero_zero, numero_um, numero_dois, numero_tres, numero_quatro, numero_cinco, numero_seis, numero_sete,numero_oito,numero_nove, ponto, soma, subtracao, multiplicacao,divisao,igual, botao_limpar;
    private TextView txt_expressao, txt_resultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*CHAMA O MÉTODO INICIAR COMPONENTES, O QUAL É RESPONSÁVEL POR MOSTRAR O NÚMERO CLICADO*/
        IniciarComponentes();
        getSupportActionBar().hide();

        /*CAPTURA OS VALORES DE CADA BUTTON.*/
        numero_zero.setOnClickListener(this);
        numero_um.setOnClickListener(this);
        numero_dois.setOnClickListener(this);
        numero_tres.setOnClickListener(this);
        numero_quatro.setOnClickListener(this);
        numero_cinco.setOnClickListener(this);
        numero_seis.setOnClickListener(this);
        numero_sete.setOnClickListener(this);
        numero_oito.setOnClickListener(this);
        numero_nove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        /*BOTÃO DE LIMPAR DEIXA NULL O TEXTO DE EXPRESSÃO E RESULTADO*/
        botao_limpar.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){

                txt_expressao.setText("");
                txt_resultado.setText("");
            }
        });

        /*CONFIGURA O BACKSPACE, PRA QUE ELE VOLTE UMA CASA QUANDO CLICADO*/
        backspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);

                }
                txt_resultado.setText("");
            }}
        );

        igual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Expression expressao = new ExpressionBuilder(txt_expressao.getText().toString()).build();
                double resultado = expressao.evaluate();
                long longResult = (long) resultado;
                if(resultado == (double)longResult){
                    txt_resultado.setText((CharSequence) String.valueOf(longResult));
                }else {
                    txt_resultado.setText((CharSequence) String.valueOf(resultado));
                }
            }
        });

        }

    private void IniciarComponentes(){
        numero_um = findViewById(R.id.numero_um);
        numero_dois = findViewById(R.id.numero_dois);
        numero_tres = findViewById(R.id.numero_tres);
        numero_quatro = findViewById(R.id.numero_quatro);
        numero_cinco = findViewById(R.id.numero_cinco);
        numero_seis = findViewById(R.id.numero_seis);
        numero_sete = findViewById(R.id.numero_sete);
        numero_oito = findViewById(R.id.numero_oito);
        numero_nove = findViewById(R.id.numero_nove);
        numero_um = findViewById(R.id.numero_um);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma );
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id. igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txt_expressao = findViewById(R.id.txt_expressao);
        txt_resultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    /*ADICIONA O NÚMERO CLICADO (OU SÍMBOLO ARITMÉTICO) DO LADO DO NÚMERO JÁ POSTO.*/
    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){
        if(txt_resultado.getText().equals("")){
            txt_expressao.setText(" ");
        }
        if(limpar_dados){
            txt_resultado.setText(" ");
            txt_expressao.append(string);
        }else{
            txt_expressao.append(txt_resultado.getText());
            txt_expressao.append(string);
            txt_resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.numero_zero:
                AcrescentarUmaExpressao("0", true);
                break;
            case R.id.numero_um:
                AcrescentarUmaExpressao("1", true);
                break;
            case R.id.numero_dois:
                AcrescentarUmaExpressao("2", true);
                break;
            case R.id.numero_tres:
                AcrescentarUmaExpressao("3", true);
                break;
            case R.id.numero_quatro:
                AcrescentarUmaExpressao("4", true);
                break;
            case R.id.numero_cinco:
                AcrescentarUmaExpressao("5", true);
                break;
            case R.id.numero_seis:
                AcrescentarUmaExpressao("6", true);
                break;
            case R.id.numero_sete:
                AcrescentarUmaExpressao("7", true);
                break;
            case R.id.numero_oito:
                AcrescentarUmaExpressao("8", true);
                break;
            case R.id.numero_nove:
                AcrescentarUmaExpressao("9", true);
                break;
            case R.id.ponto:
                AcrescentarUmaExpressao(".", false);
                break;
            case R.id.soma:
                AcrescentarUmaExpressao("9", false);
                break;
            case R.id.subtracao:
                AcrescentarUmaExpressao("-", false);
                break;
            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;
            case R.id.divisao:
                AcrescentarUmaExpressao("/", false);
                break;
        }
    }
}
