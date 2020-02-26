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

//        reference.child("usuarios2").child("001").child("nome").setValue("Emanoel");

       //utilizando objetos
       DatabaseReference usuarios = reference.child("usuarios");
       
       usuarios.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Log.i("FIREBASE", dataSnapshot.getValue().toString());
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });


//      Salvando em banco de dados
       /*Usuarios usuario = new Usuarios();

       usuario.setNome("Marilia");
       usuario.setSobrenome("Mendonca");
       usuario.setIdade(28);


       usuarios.child("002").setValue(usuario);


       DatabaseReference produtos = reference.child("produtos");
       Produtos produto = new Produtos();
       produto.setDescricao("Notebook");
       produto.setMarca("Samsung");
       produto.setPreco(2000.89);

       produtos.child("002").setValue(produto);*/
    }
}
