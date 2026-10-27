package ec.edu.taller;

import com.sun.java.accessibility.util.Translator;

import java.util.*;

public class GestorImpresiones {
    private Queue<TrabajoImpresion> colaTrabajos;
    private int capacidadMaxima;

    public GestorImpresiones(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.colaTrabajos = new PriorityQueue<>(Comparator.comparingInt(TrabajoImpresion::getPrioridad));
    }

    public boolean registrarTrabajo(TrabajoImpresion trabajo) {
        if (trabajo==null) {
            return false;
        }
        String codigo = trabajo.getCodigo();

        if (codigo==null || codigo.trim().isEmpty()) {
            return false;
        }
        if (existeTrabajo(codigo)) {
            return false;
        }
        if (colaTrabajos.size()>=capacidadMaxima) {
            return false;
        }
        return colaTrabajos.offer(trabajo);
    }

    public boolean existeTrabajo(String codigo) {
        if (codigo==null || codigo.trim().isEmpty()) {
            return false;
        }
        for (TrabajoImpresion trabajo : colaTrabajos) {
            if (trabajo.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public TrabajoImpresion consultarSiguienteTrabajo() {
        return colaTrabajos.peek();
    }

    public TrabajoImpresion procesarSiguienteTrabajo() {
        TrabajoImpresion trabajo = colaTrabajos.poll();

        if (trabajo==null) {
            return null;
        }
        trabajo.setEstado("PROCESADO");
        return trabajo;
    }

    public int contarTrabajosPendientes() {
        return  colaTrabajos.size();
    }

    public int consultarEspaciosDisponibles() {
        return capacidadMaxima - colaTrabajos.size();
    }

    public List<TrabajoImpresion> listarTrabajos() {
        List<TrabajoImpresion> trabajosOrdenados = new ArrayList<>(colaTrabajos);

        trabajosOrdenados.sort(Comparator.comparing(TrabajoImpresion::getPrioridad));
        return trabajosOrdenados;
    }
}