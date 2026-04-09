package part2.part2_1;

public class Intern extends Employee {

    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    /**
     * Бонус стажёра = фиксированные 10000 рублей.
     */
    @Override
    public double calculateBonus() {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        return 10000;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}
