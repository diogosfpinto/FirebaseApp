package com.diogopinto.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //Referencia para o banco será a raiz do BD:
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //utilizando objetos
        DatabaseReference usuarios = reference.child("usuarios");

//        Pesquisas
//        Selecionar o usuário pelo seu identifcador unico
//        DatabaseReference usuarioPesquisa = usuarios.child("-M3WKPDDnV0n_X96hQ54");

//        Ordena os dados para depois aplicar o filtro
//        Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Diogo");

//        Limita a pesquisa para os dois primeiros usuários
//        Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);

//        Limita a pesquisa para os dois ultimos usuários
//        Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);

//        Maior ou igual (>=)
//        Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(35);

//        Menor ou igual (<=)
//        Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(35);

//        Entre valores
//        Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(30).endAt(40);

//        Filtrar palavras
        /*uf8ff é por causa do formato unicode*/
        Query usuarioPesquisa = usuarios.orderByChild("nome")
                                        .startAt("M").endAt("M" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    /*Usuarios dadosUsuario = dataSnapshot.getValue(Usuarios.class);
                    Log.i("usuario", "nome: "+dadosUsuario.getNome());*/
                    Log.i("usuario", dataSnapshot.getValue().toString());
                }catch(NullPointerException e){
                    Log.i("usuario", "Usuário não Localizado!");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })


//      Salvando em banco de dados
       /*Usuarios usuario = new Usuarios();

       usuario.setNome("Rodrigo");
       usuario.setSobrenome("Matos");
       usuario.setIdade(35);

//     Definindo de forma dinamica
        usuarios.push().setValue(usuario);*/

        /*//      Forma manual
       usuarios.child("002").setValue(usuario);*/

       /*DatabaseReference produtos = reference.child("produtos");
       Produtos produto = new Produtos();
       produto.setDescricao("Notebook");
       produto.setMarca("Samsung");
       produto.setPreco(2000.89);*//*

//       Definindo de forma dinamica
       produtos.push().setValue(produto)*/;
    }
}
