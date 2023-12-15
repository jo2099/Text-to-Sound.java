enum TypeNote{
    DO('C'),
    RE('D'),
    MI('E'),
    FA('F'),
    SOL('G'),
    LA('A'),
    SI('B');

    private Character value;

    private TypeNote(Character value){
        this.value = value;
    }

    public Character getValue(){
        return this.value;
    }

    public static TypeNote getNoteByChar(Character value){
        for(TypeNote note : TypeNote.values()){
            if(note.getValue().equals(value)){
                return note;
            }
        }
        
        throw new IllegalArgumentException("Note not found");
    }

    public int getFreq(int octave)
    {
        final int NUM_NOTES_OCTAVE=12;
        switch(this)
        {
            case DO:
                final int DO_1st_OCTAVE=0;
                return DO_1st_OCTAVE +NUM_NOTES_OCTAVE *octave;
            case RE:
                final int RE_1st_OCTAVE=2;
                return RE_1st_OCTAVE +NUM_NOTES_OCTAVE *octave;
            case MI:
                final int MI_1st_OCTAVE=4;
                return MI_1st_OCTAVE +NUM_NOTES_OCTAVE *octave;
            case FA:
                final int FA_1st_OCTAVE=5;
                return FA_1st_OCTAVE +NUM_NOTES_OCTAVE *octave;
            case SOL:
                final int SOL_1st_OCTAVE=7;
                return SOL_1st_OCTAVE +NUM_NOTES_OCTAVE *octave;
            case LA:
                final int LA_1st_OCTAVE=9;
                return LA_1st_OCTAVE +NUM_NOTES_OCTAVE *octave;
            case SI:
                final int SI_1st_OCTAVE=11;
                return SI_1st_OCTAVE +NUM_NOTES_OCTAVE *octave;
        }

        throw new IllegalArgumentException("Note not found");
    }
}