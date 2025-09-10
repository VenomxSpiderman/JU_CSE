import java.util.concurrent.locks.*;

class NoticeBoard {
    private String notice;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    
    public String readNotice() {
        while (!lock.readLock().tryLock()) {
            System.out.println(Thread.currentThread().getName() + " is waiting to read...");
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            return notice;
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public void writeNotice(String newNotice) {
        lock.writeLock().lock();
        try {
            System.out.println("Updating notice...");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notice = newNotice;
            System.out.println("Notice updated!");
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class Reader implements Runnable {
    private NoticeBoard board;
    
    public Reader(NoticeBoard board) {
        this.board = board;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " reads: " + board.readNotice());
    }
}

class Writer implements Runnable {
    private NoticeBoard board;
    private String notice;
    
    public Writer(NoticeBoard board, String notice) {
        this.board = board;
        this.notice = notice;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting to write...");
        board.writeNotice(notice);
    }
}

class NoticeBoardDemo {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();
        board.writeNotice("Initial notice");
        
        for (int i = 0; i < 5; i++) {
            new Thread(new Reader(board), "Reader-" + i).start();
        }
        
        new Thread(new Writer(board, "Updated notice 1"), "Writer-1").start();
        
        for (int i = 5; i < 10; i++) {
            new Thread(new Reader(board), "Reader-" + i).start();
        }
        
        new Thread(new Writer(board, "Updated notice 2"), "Writer-2").start();
        
        for (int i = 10; i < 15; i++) {
            new Thread(new Reader(board), "Reader-" + i).start();
        }
    }
}