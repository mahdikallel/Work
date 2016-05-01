package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmk.workfinder.AuthentificationActivity;
import com.example.dmk.workfinder.Profil;
import com.example.dmk.workfinder.R;

import java.util.ArrayList;

/**
 * Created by Emna-Kallel on 01/05/2016.
 */
public class InfoFragmentWork extends Fragment implements View.OnClickListener {
    public InfoFragmentWork() {

    }


    private TextView mOffreEmploi;
    private Button mButton;
    private TextView mInputName;
    ArrayList<String> listOffre = new ArrayList<String>();
    private Profil prof = new Profil();

    int i=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.premier_fragment, container, false);
        listOffre.add("Bac +2.Expérience 2 ans contact: cisen@gmail.com ");
        listOffre.add(" Bac +5.Expérience 3 ans contact: grh@telnet.tn");
        mButton = (Button) view.findViewById(R.id.fragment_button);
        mInputName = (TextView) view.findViewById(R.id.edit_name);

        mOffreEmploi = (TextView) view.findViewById(R.id.offre_emploi);


        mInputName.setText(prof.workList.get(prof.getPos_domain()).toString());
        mOffreEmploi.setText(listOffre.get(i));
        mButton.setOnClickListener(this);
        i++;
        i=i%2;
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fragment_button) {
            {
                getFragmentManager().beginTransaction().remove(this).commit();


            }
        }
    }
}
