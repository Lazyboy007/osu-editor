package componentsTest

import components.Slider
import coreTest.BaseTest

class SliderTest extends BaseTest {
  "A slider" should "keep the timestamp for beginning and end correctly" in {
    val slider = new Slider((0, 0), (100, 100), 3, 4)
    assert(slider.getTime == 3)
    assert(slider.getEndTime == 4)
    slider.setTime(1)
    assert(slider.getTime == 1)
    slider.setEndTime(5)
    assert(slider.getEndTime == 5)
  }

  it should "always return its starting- and end points correctly" in {
    val slider = new Slider((0, 1), (100, 101), 3, 4)
    assert(slider.getX == 0)
    assert(slider.getY == 1)
    assert(slider.getEndX == 100)
    assert(slider.getEndX == 101)

    slider.setPosition((2, 3))
    assert(slider.getX == 2)
    assert(slider.getY == 3)

    slider.setEndPosition((102, 103))
    assert(slider.getEndX == 102)
    assert(slider.getEndX == 103)
  }

  it should "never end before it begins" in {
    assertThrows[IllegalArgumentException] {
      val slider = new Slider((0, 0), (5, 5), 3, 1)
    }
    assertThrows[IllegalArgumentException] {
      val slider = new Slider((0, 0), (5, 5), 2, 3)
      slider.setEndTime(1)
    }
    assertThrows[IllegalArgumentException] {
      val slider = new Slider((0, 0), (5, 5), 2, 3)
      slider.setTime(5)
    }
  }
}

