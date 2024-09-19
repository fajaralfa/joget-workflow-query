package com.fajaralfa.hashvariablequery;

import org.joget.apps.app.model.DefaultHashVariablePlugin;

import java.util.ArrayList;
import java.util.Collection;

public class KaryawanEmail extends DefaultHashVariablePlugin {
    @Override
    public String getPrefix() {
        return "karyawan";
    }

    @Override
    public String processHashVariable(String s) {
        KaryawanEmailDAO dao = new KaryawanEmailDAO();

        String nrik = s;
        String column = "c_email"; // default column

        for (String syntax : availableSyntax()) {
            syntax = syntax.replaceAll("karyawan.NRIK", "");
            if (nrik.contains(syntax)) {
                nrik = nrik.replaceAll(syntax, "");
                column = syntax.substring(1);
            }
        }

        return dao.getColumnByNrik(column, nrik);
    }

    @Override
    public Collection<String> availableSyntax() {
        Collection<String> syntax = new ArrayList<>();

        syntax.add("karyawan.NRIK.c_email");
        syntax.add("karyawan.NRIK.c_namaKaryawan");

        return syntax;
    }

    @Override
    public String getName() {
        return "Karyawan Email Hash Variable";
    }

    @Override
    public String getVersion() {
        return "1.0-SNAPSHOT";
    }

    @Override
    public String getDescription() {
        return "Get Karyawan Email using Hash Variable";
    }

    @Override
    public String getLabel() {
        return "Karyawan Email Hash Variable";
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getPropertyOptions() {
        return "";
    }
}
