// 1. VideoLecture interface
interface VideoLecture {
    String getInfo();
    void play();
}

// 2. RealVideoLecture class that simulates loading and playing a video lecture
class RealVideoLecture implements VideoLecture {
    private String title;

    public RealVideoLecture(String title) {
        this.title = title;
        loadVideo();
    }

    private void loadVideo() {
        System.out.println("Loading video lecture: " + title);
    }

    @Override
    public String getInfo() {
        return "Video Lecture: " + title;
    }

    @Override
    public void play() {
        System.out.println("Playing video lecture: " + title);
    }
}

// 3. ProxyVideoLecture class implementing lazy loading
class ProxyVideoLecture implements VideoLecture {
    private String title;
    private RealVideoLecture realVideoLecture;

    public ProxyVideoLecture(String title) {
        this.title = title;
    }

    @Override
    public String getInfo() {
        return "Proxy for: " + title;
    }

    @Override
    public void play() {
        if (realVideoLecture == null) {
            realVideoLecture = new RealVideoLecture(title);
        }
        realVideoLecture.play();
    }
}

// 5. OnlineCourse class containing multiple video lectures
class OnlineCourse {
    private VideoLecture[] lectures;

    public OnlineCourse(VideoLecture[] lectures) {
        this.lectures = lectures;
    }

    public void playLecture(int index) {
        if (index < 0 || index >= lectures.length) {
            System.out.println("Invalid lecture index.");
            return;
        }
        lectures[index].play();
    }

    public void showLectureInfo(int index) {
        if (index < 0 || index >= lectures.length) {
            System.out.println("Invalid lecture index.");
            return;
        }
        System.out.println(lectures[index].getInfo());
    }
}

// 6. LearningPlatformApp to demonstrate proxy in action
public class OnlineLearningPlatform {
    public static void main(String[] args) {
        VideoLecture lecture1 = new ProxyVideoLecture("Introduction to Java");
        VideoLecture lecture2 = new ProxyVideoLecture("Design Patterns in Java");
        VideoLecture lecture3 = new ProxyVideoLecture("Advanced Java Programming");

        OnlineCourse course = new OnlineCourse(new VideoLecture[]{lecture1, lecture2, lecture3});

        // Show lecture info
        course.showLectureInfo(0);
        course.showLectureInfo(1);
        course.showLectureInfo(2);

        // Play lectures
        System.out.println("\nPlaying lectures:");
        course.playLecture(0); // First time, loads the video
        course.playLecture(1); // First time, loads the video
        course.playLecture(2); // First time, loads the video

        // Play the lectures again to demonstrate lazy loading
        System.out.println("\nPlaying lectures again:");
        course.playLecture(0); // Video should already be loaded
        course.playLecture(1); // Video should already be loaded
    }
}
