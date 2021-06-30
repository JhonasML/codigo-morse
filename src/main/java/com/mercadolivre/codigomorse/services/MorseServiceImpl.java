package com.mercadolivre.codigomorse.services;

import com.mercadolivre.codigomorse.dtos.RequestDTO;
import com.mercadolivre.codigomorse.dtos.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Service
public class MorseServiceImpl implements MorseService {

    private static Map<String, String> dictionary;

    @Autowired
    public MorseServiceImpl(Environment env) throws IOException {
            String filePath = env.getProperty("dictionary.path", "src/main/resources/static/dictionary.txt");

            Path path = FileSystems.getDefault().getPath(filePath);
            dictionary = Files.lines(path)
                    .filter(s -> s.matches("^\\w+:[.|-]+"))
                    .collect(Collectors.toMap(k -> k.split(":")[1], v -> v.split(":")[0]));
    }

    @Override
    public ResponseDTO decode(RequestDTO morse) {
        var morseString = morse.getMorse();

        String[] words = morseString.split("[ ]{3}");
        StringJoiner wordsJoiner = new StringJoiner(" ");

        for (String word : words) {
            wordsJoiner.add(decodeWord(word));
        }

        return new ResponseDTO(wordsJoiner.toString());
    }

    private String decodeWord(String word) {
        String[] letters = word.split("[ ]");
        StringJoiner lettersJoiner = new StringJoiner("");

        for (String letter : letters) {
            lettersJoiner.add(dictionary.get(letter));
        }
        return lettersJoiner.toString();
    }
}
