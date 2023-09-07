
package firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class FirebaseGetObject {
    
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ruta/al/objeto");
    databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // Aquí obtienes los datos del objeto
        // Puedes acceder a los datos utilizando dataSnapshot.getValue() u otros métodos
        MiObjeto objeto = dataSnapshot.getValue(MiObjeto.class);

        // Ahora puedes trabajar con el objeto obtenido
        // Por ejemplo, imprimirlo en el log
        Log.d("FirebaseData", "Objeto: " + objeto.toString());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // Manejo de errores en caso de que ocurra un error en la lectura
        Log.w("FirebaseData", "Error al leer los datos", databaseError.toException());
    }
});


}
