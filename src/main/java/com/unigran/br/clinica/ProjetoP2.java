/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.unigran.br.clinica;

import com.unigran.br.clinica.Telas.GFuncionario.CadastroFuncionario;
import com.unigran.br.clinica.Telas.GFuncionario.EdicaoFuncionario;
import com.unigran.br.clinica.Telas.GFuncionario.SelecaoFuncionario;
import com.unigran.br.clinica.Telas.GMaterial.CadastroMaterial;
import com.unigran.br.clinica.Telas.GMaterial.EdicaoMaterial;
import com.unigran.br.clinica.Telas.GPaciente.CadastroPaciente;
import com.unigran.br.clinica.Telas.GPaciente.EdicaoPaciente;
import com.unigran.br.clinica.Telas.GPaciente.PesquisaPaciente;
import com.unigran.br.clinica.Telas.GProntuario.PesquisaProntuario;
import com.unigran.br.clinica.Telas.GProntuario.ProntuarioTela;
import com.unigran.br.clinica.Telas.Login;
import com.unigran.br.clinica.Telas.Principal;

/**
 *
 * @author gabriel.guimaraes
 */
public class ProjetoP2 {

    public static void main(String[] args) {

        new EdicaoFuncionario();
        new CadastroFuncionario();
        new SelecaoFuncionario();

        new EdicaoMaterial();
        new CadastroMaterial();
        new PesquisaPaciente();

        new EdicaoPaciente();
        new CadastroPaciente();
        new PesquisaPaciente();

        new ProntuarioTela(null);
        new PesquisaProntuario();

        new Login();
        new Principal(4);
    }
}
