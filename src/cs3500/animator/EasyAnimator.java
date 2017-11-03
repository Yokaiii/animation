package cs3500.animator;

import cs3500.animator.views.AnimationFileReader;
import cs3500.animator.model.Animation.Builder;

import cs3500.animator.views.SVGView;
import cs3500.animator.views.TextView;
import cs3500.animator.views.TweenView;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public final class EasyAnimator {


  public static void main(String[] args) throws FileNotFoundException {
    List<String> inFile = new ArrayList<>();
    List<String> outFile = new ArrayList<>();
    List<String> type = new ArrayList<>();
    List<String> speed = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    while (sc.hasNext()) {

      String s = sc.next();

      switch (s) {
        case "-if":
          inFile.add(sc.next());
          break;
        case "-iv":
          switch (sc.next()) {
            case "text":
              type.add("text");
              break;
            case "visual":
              type.add("visual");
              new TweenView();
              break;
            case "svg":
              type.add("svg");
              break;
            default:
              throw new IllegalArgumentException();
          }
          break;
        case "-speed":
          speed.add(sc.next());
          break;
        case "-o":
          outFile.add(sc.next());
          break;
        default:
          throw new IllegalArgumentException();
      }
      if(inFile.size() == 1 && outFile.size() == 1 && type.size() == 1 && speed.size() == 1) {
        stuff(inFile, outFile, type, speed);
      }
    }
  }

  private static void stuff(List<String> inFile, List<String> outFile, List<String> type,
      List<String> speed) {
    if (type.get(0).equals("text")) {
      TextView textView = new TextView(new AnimationFileReader(), inFile.get(0), new Builder(), outFile.get(0),
          Integer.valueOf(speed.get(0)));
      textView.view();
    }
    else if (type.get(0).equals("svg")) {
      SVGView svgView = new SVGView(new AnimationFileReader(), inFile.get(0), new Builder(), outFile.get(0),
          Integer.valueOf(speed.get(0)));
      svgView.view();
    }
    else {

    }
  }

}
