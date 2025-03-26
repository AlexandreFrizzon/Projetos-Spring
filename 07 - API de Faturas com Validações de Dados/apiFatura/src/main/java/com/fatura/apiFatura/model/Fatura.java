package com.fatura.apiFatura.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O Número do cartão não pode estar em branco.")
    @Pattern(regexp = "\\d{16}", message="O Número do cartão Deve conter exatamente 16 dígitos numéricos.")
    private String numeroCartao;

    @NotBlank(message="O Nome do titular não pode estar em branco.")
    @Size(min=3, max=100, message = "O nome deve possuir entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "O valor não pode ser nulo.")
    @DecimalMin(value="10.00", message = "O valor minimo é R$10")
    @DecimalMax(value="5000.0", message="O valor máximo é R$5.000")
    private Double valor;

    @NotNull(message = "A data não pode ser Nula")
    @FutureOrPresent(message = "A data de vencimento deve ser a data atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O e-mail deve ser válido.")
    private String email;
}
