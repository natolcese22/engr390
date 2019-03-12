package com.example.y_barham.breathleaf;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

public class settingsDialogFragment extends DialogFragment {
    protected Switch doNotDisturbSwitch;
    protected Switch vocalGuideSwitch;
    protected Switch musicSwitch;
    protected Switch visualsSwitch;
    protected Button dismissButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        doNotDisturbSwitch = view.findViewById(R.id.doNotDisturbSwitch);
        vocalGuideSwitch = view.findViewById(R.id.vocalGuideSwitch);
        musicSwitch = view.findViewById(R.id.vocalGuideSwitch);
        visualsSwitch = view.findViewById(R.id.vocalGuideSwitch);
        dismissButton = view.findViewById(R.id.dismissButton);

        dismissButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;

    }
}
