package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
public class Ticket {
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public void marcarSalida() {
        Random random = new Random();
        this.horaSalida = LocalDateTime.now().plusMinutes(random.nextInt(200)+1);
    }

    public long calcularMinutos() {
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public double calcularPrecio() {
        // TO DO implementar el metodo para calcular el importe a abonar segun el tipo de vehiculo
        // AUTO -> 100, SUV -> 130, PICKUP -> 180
        // el importe es por hora redondeando el tiempo hacia arriba,
        // por ejemplo si estuvo 45 minutos se le tarifa por 60, si estuvo 80 minutos se le tarifa por 120 minutos, etc...
        // retornar el importe final
        long tiempo = calcularMinutos();

        if(vehiculo.getTipo() == Vehiculo.Tipo.AUTO){
          if(tiempo<=60){
              return 100;
           }else if( tiempo >60 && tiempo<=120){
              return 200;
          } else if(tiempo>120 && tiempo<=180){
              return 300;
          } else if(tiempo>180){
              return 400;
          }
        }else if(vehiculo.getTipo()== Vehiculo.Tipo.PICKUP){
            if(tiempo<=60){
                return 180;
            }else if( tiempo >60 && tiempo<=120){
                return 360;
            } else if(tiempo>120 && tiempo<=180){
                return 540;
            } else if(tiempo>180){
                return 720;
            }

        }else if (vehiculo.getTipo() == Vehiculo.Tipo.SUV){
            if(tiempo<=60){
                return 130;
            }else if( tiempo >60 && tiempo<=120){
                return 260;
            } else if(tiempo>120 && tiempo<=180){
                return 390;
            } else if(tiempo>180){
                return 520;
            }

        }

        return 0;
    }

}