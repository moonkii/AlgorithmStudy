function solution1(nums) {
  function pickPokemon(picks, rest) {
    if (picks.length === nums.length / 2 || rest.length === 0) {
      return picks.length;
    }

    if (!picks.includes(rest[0])) {
      return pickPokemon([rest[0], ...picks], rest.slice(1));
    }

    return pickPokemon(picks, rest.slice(1));
  }

  return pickPokemon([], nums);
}

function solution2(nums) {
  const picks = new Set(nums);
  return Math.min(nums.length / 2, picks.size);
}

function solution3(nums) {
  const picks = nums.reduce((acc, cur) => (
    acc.includes(cur) ? acc : [cur, ...acc]),
  []);

  return Math.min(nums.length / 2, picks.length);
}

function solution4(nums) {
  const picks = nums.filter((num, index) => nums.indexOf(num) === index);

  return Math.min(nums.length / 2, picks.length);
}

test('sample', () => {
  [solution1, solution2, solution3, solution4].forEach((solution) => {
    expect(solution([3, 1, 2, 3])).toBe(2);
    expect(solution([3, 3, 3, 2, 2, 4])).toBe(3);
    expect(solution([3, 3, 3, 2, 2, 2])).toBe(2);
  });
});
