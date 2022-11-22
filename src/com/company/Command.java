package com.company;

public class Command {
    private Snapshot backup;

    public void makeBackup(User user){
        backup = user.createSnapShot(user);
    }

    public void undo(){
        if (backup != null)
            backup.restore();
    }
}
