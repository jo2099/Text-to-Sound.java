import javax.sound.midi.*;
import javax.sound.midi.Sequence;

import javax.sound.midi.Track;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.InvalidMidiDataException;

public class MidiHandler{
    private int octave;
    private Sequence currentSequence;
    private Track track;
    private long currentTick;
    private int currentInstrument;

    // constructor
    public MidiHandler() {
        this.octave = 4;
        try {
            this.currentSequence = new Sequence(Sequence.PPQ, 1);
            this.track = currentSequence.createTrack();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        this.currentTick = 0;
        this.currentInstrument = 0;
    }

    public void changeOctave(int octave) {
        if (octave < 0 || octave > 10) {
            throw new IllegalArgumentException("Octave must be between 0 and 10");
        }
        this.octave = octave;
    }

    public void changeInstrument(int instrument) {
        if (instrument < 0 || instrument > 127) {
            throw new IllegalArgumentException("Instrument must be between 0 and 127");
        }
        this.currentInstrument = instrument;
    }

    private long getDurationInTicks(long durationMilli) {
        return (long) ((durationMilli / 1000.0) * currentSequence.getResolution());
    }

    public void addNote(TypeNote typeNote, int octave, int durationMilli, int intensity) {
        if (intensity < 0 || intensity > 127) {
            throw new IllegalArgumentException("Intensity must be between 0 and 127");
        }
        try {
            // Create the note on message
            ShortMessage noteOnMessage = new ShortMessage();
            noteOnMessage.setMessage(ShortMessage.NOTE_ON, currentInstrument, typeNote.getFreq(octave), intensity);
            MidiEvent noteOnEvent = new MidiEvent(noteOnMessage, currentTick);
            track.add(noteOnEvent);

            // Update the current tick
            currentTick += getDurationInTicks(durationMilli);

            // Create the note off message
            ShortMessage noteOffMessage = new ShortMessage();
            noteOffMessage.setMessage(ShortMessage.NOTE_OFF, currentInstrument, typeNote.getFreq(octave), intensity);
            MidiEvent noteOffEvent = new MidiEvent(noteOffMessage, currentTick);
            track.add(noteOffEvent);

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    public Sequence convertTextToSequence(Character[] content) {
        if (content == null || content.length == 0) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        for (Character character : content) {
            TypeNote note = TypeNote.getNoteByChar(character);
            addNote(
                    note,
                    octave,
                    1000,
                    100);
        }
        return currentSequence;
    }
}
