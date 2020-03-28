package com.diogopinto.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

//      Salvando em banco de dados
       Usuarios usuario = new Usuarios();

       usuario.setNome("Weberty");
       usuario.setSobrenome("Mendonca");
       usuario.setIdade(25);

/*//      Forma manual
       usuarios.child("002").setValue(usuario);*/

//     Definindo de forma dinamica
        usuarios.push().setValue(usuario);

       DatabaseReference produtos = reference.child("produtos");
       Produtos produto = new Produtos();
       produto.setDescricao("Notebook");
       produto.setMarca("Samsung");
       produto.setPreco(2000.89);

//       Definindo de forma dinamica
       produtos.push().setValue(produto);
    }
}
