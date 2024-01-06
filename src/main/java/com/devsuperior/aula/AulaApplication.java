package com.devsuperior.aula;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class AulaApplication implements CommandLineRunner {

    OrderService orderService;

    public AulaApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AulaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Código: ");
            int code = sc.nextInt();

            System.out.println("Valor básico: ");
            double basic = sc.nextDouble();

            System.out.println("Porcentagem de desconto: ");
            double discount = sc.nextDouble();

            Order order = Order.builder()
                    .code(code)
                    .basic(basic)
                    .discount(discount)
                    .build();

            double total = orderService.total(order);
            System.out.println("Pedido código: " + order.getCode());
            System.out.printf("Valor total: R$ %.2f", total);

        } catch (InputMismatchException e) {
            System.out.println("Input inválido. Por favor, considere um valor válido.");
        } catch (Exception e) {
            System.out.println("Erro desconhecido ao ler dados do input.");
        }
    }
}
