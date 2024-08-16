package ticketbookingsystem;

public class TicketBookingSystem {
    private int availableTickets;

    public TicketBookingSystem(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public boolean reserveTicket() {
        if (availableTickets > 0) {
            availableTickets--;
            return true;
        } else {
            return false;
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(10); 

        Runnable userTask = () -> {
            for (int i = 0; i < 5; i++) {
                boolean success = bookingSystem.reserveTicket();
                if (success) {
                    System.out.println(Thread.currentThread().getName() + " reservó una entrada.");
                } else {
                    System.out.println(Thread.currentThread().getName() + " no pudo reservar una entrada.");
                }
            }
        };

        Thread[] threads = new Thread[20]; 

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(userTask, "Usuario-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Entradas restantes: " + bookingSystem.getAvailableTickets());
    }
}
