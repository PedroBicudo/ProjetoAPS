package apps.learn.projetoaps.data.model;

import android.os.Parcel;

import org.parceler.ParcelConverter;
import org.parceler.Parcels;
import org.parceler.converter.ArrayListParcelConverter;

import java.util.ArrayList;
import java.util.List;

public class QuizAlternativasParcelConverter implements ParcelConverter<List<Alternativa>> {

    @Override
    public void toParcel(List<Alternativa> input, Parcel parcel) {
        parcel.writeInt(input.size());
        for (Alternativa alternativa: input) {
            parcel.writeParcelable(Parcels.wrap(alternativa), 0);
        }
    }

    @Override
    public List<Alternativa> fromParcel(Parcel parcel) {
        int size = parcel.readInt();
        List<Alternativa> alternativas = new ArrayList<>();
        for (int count=0; count < size; count++) {
            alternativas.add((Alternativa) Parcels.unwrap(parcel.readParcelable(Alternativa.class.getClassLoader())));
        }
        return alternativas;
    }
}
