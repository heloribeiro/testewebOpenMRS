#language: pt
Funcionalidade: Registrar dados do Paciente, para dar entrada no Hospital

  @registrarPaciente
  Cenario: Registrar os dados do Paciente
    Dado que acesso o site OpenMRS
    E coloco meu login e senha
    E clico na opção InpacientWard
    E clico em Log In
    Quando logo na pagina clico em Registrar Paciente
    E informo todos os dados do paciente
    Então clico em confirmar e tenho os dados registrados
