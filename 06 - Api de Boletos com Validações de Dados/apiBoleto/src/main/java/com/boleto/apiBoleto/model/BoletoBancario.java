package com.boleto.apiBoleto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "boletos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class BoletoBancario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O banco não pode estar em branco")
    @Pattern(regexp = "\\d{3}", message="O código do banco deve conter 3 caracteres. ")
    private String banco;

    @NotBlank(message = "A agência não pode estar em branco.")
    @Pattern(regexp = "\\d{4}", message = "A agência deve possuir 4 digitos.")
    private String agencia;

    @NotBlank(message = "A conta não pode estar em branco.")
    @Pattern(regexp = "\\d{4}", message = "A conta deve possuir 4 digitos.")
    private String conta;

    @NotBlank(message = "O código de Barras não pode estar em branco.")
    @Pattern(regexp = "\\d{5}\\.\\d{5} \\d{5}\\.\\d{6} \\d{5}\\.\\d{6} \\d \\d{14}",
                    message = "Codigo de barras deve possuir o formato: 00000.00000.00000.000000.0000 0 000000 ")
    private String codigoBarra;

    @NotNull(message = "O valor não pode ser nulo.")
    @DecimalMin(value="0.01", message = "O valor minimo é 1 centavo")
    @DecimalMax(value="10000.0", message="O valor máximo é 10.000")
    private Double valor;

    @NotNull(message = "A data não pode ser Nula")
    @FutureOrPresent(message = "A data de vencimento deve ser a data atual ou futura")
    private LocalDate dataVencimento;

    @NotBlank(message = "O nome do pagador não pode estar em branco")
    @Size(min=10, max=100, message = "O nome deve possuir entre 10 e 100 caracteres")
    private String nomePagador;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "\\d{11}", message = "O Cpf deve possuir 11 digitos")
    private String cpf;

}
